package com.example.modasluz.services;

import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.dto.CatalogoPersonalizadoDTO;
import com.example.modasluz.mappers.*;
import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.Talla;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.TallaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogoService {

    @Autowired
    private final TallaRepositorio tallaRepositorio;

    @Autowired
    private final ProductoService productoService;

    @Autowired
    private final CatalogoRepositorio catalogoRepositorio;

    @Autowired
    private final CatalogoMapper catalogoMapper;

    @Autowired
    private final Mappers mappers;
    

    public Catalogo guardar(CatalogoDTO dto) {
        return catalogoRepositorio.save(catalogoMapper.toEntity(dto));
    }

    public Catalogo guardar(Catalogo catalogo) {
        return catalogoRepositorio.save(catalogo);
    }

    public void eliminar(Integer id) {
        catalogoRepositorio.deleteById(id);
    }

    public List<CatalogoDTO> getAllDTO() {
        List<Catalogo> catalogo = catalogoRepositorio.findAll();
        if (catalogo.isEmpty()) {
            throw new RuntimeException("No hay datos en el catalogo");
        }
        return catalogo.stream().map(mappers::toDTO).collect(Collectors.toList());
    }

    public List<Catalogo> getAll() {
        return catalogoRepositorio.findAll();
    }

    public CatalogoDTO getById(Integer id) {
        return catalogoMapper.toDTO(catalogoRepositorio.findById(id).orElse(null));
    }


    public CatalogoDTO consultarDisponibilidad(Integer idProducto, String nombreTalla) throws Exception {
        try{
            Talla talla = tallaRepositorio.findByTipo(nombreTalla);
            Producto producto = productoService.getByIdNormal(idProducto);
            if (producto == null){
                throw new Exception("El producto con el id: " + idProducto + " no existe");
            }
            if(talla == null){
                throw new Exception("La talla seleccionada no se encuentra en el catalogo");
            }
            Catalogo catalogo = catalogoRepositorio.findByProductoIdAndTallaId(idProducto, talla.getId());
            if (catalogo.getCantidad()>0 ) {
                return  mappers.toDTO(catalogo);
            }
            else{
                throw new Exception("El producto no se encuentra disponible en la talla seleccionada en el catalogo");
            }
        }catch (Exception e) {
            if (e.getMessage().equals("La talla seleccionada no se encuentra en el catalogo")) {
                throw e;
            } else if (e.getMessage().equals("El producto con el id: " + idProducto + " no existe")) {
                throw e;
            } else {
                throw new Exception("El producto no se encuentra disponible en la talla seleccionada en el catalogo");
            }
        }
    }

    public CatalogoDTO  modificarStock (CatalogoPersonalizadoDTO catalogoPersonalizadoDTO) throws  Exception{
        try{
            Talla talla = tallaRepositorio.findByTipo(catalogoPersonalizadoDTO.getTalla());
            if (talla == null){
                throw new Exception("La talla seleccionada no se encuentra en el catalogo");
            }
            Catalogo catalogo = catalogoRepositorio.findByProductoIdAndTallaId(catalogoPersonalizadoDTO.getId_producto(), talla.getId());
            if (catalogo != null){
                catalogo.setCantidad(catalogoPersonalizadoDTO.getCantidad());
                catalogoRepositorio.save(catalogo);
                return mappers.toDTO(catalogo);
            }else{
                throw new Exception("El producto no se encuentra en el catalogo");
            }
        } catch (Exception e) {
           if (e.getMessage().equals("El producto no se encuentra en el catalogo")){
                throw e;
           }
           if (e.getMessage().equals("La talla seleccionada no se encuentra en el catalogo")){
                throw e;
           }
           else{
                throw new Exception(e);
           }
        }
    }
}
