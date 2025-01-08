package com.example.modasluz.services;

import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.dto.CatalogoPersonalizadoDTO;
import com.example.modasluz.mappers.CatalogoMapper;
import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.TallaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoService {

    private final TallaRepositorio tallaRepositorio;
    private final ProductoService productoService;
    private CatalogoRepositorio catalogoRepositorio;
    private CatalogoMapper catalogoMapper;

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
        return catalogoMapper.toDTO(catalogoRepositorio.findAll());
    }

    public List<Catalogo> getAll() {
        return catalogoRepositorio.findAll();
    }

    public CatalogoDTO getById(Integer id) {
        return catalogoMapper.toDTO(catalogoRepositorio.findById(id).orElse(null));
    }
    public Catalogo getByIdNormal(Integer id) {
        return catalogoRepositorio.findById(id).orElse(null);
    }

    public Object consultarDisponibilidad(Integer idProducto, String talla) {
        try{
            Integer tallaid = tallaRepositorio.findByTipo(talla).getId();
            Catalogo catalogo = catalogoRepositorio.findByProductoIdAndTallaId(idProducto, tallaid);
            if (catalogo.getCantidad()>0  ) {
                CatalogoDTO catalogoDTO =  catalogoMapper.toDTO(catalogo);
                return catalogoDTO;
            } else {
                return "No se encuentra stock del producto disponible";
            }
        }catch (Exception e) {
            Producto producto = productoService.getByIdNormal(idProducto);
            return "El producto: "+ producto.getNombre() +" con la talla seleccionada " +talla+" no se encuentra en el catalogo";
        }
    }

    public Object  modificarStock (CatalogoPersonalizadoDTO catalogoPersonalizadoDTO){
        try{
            Integer tallaid = tallaRepositorio.findByTipo(catalogoPersonalizadoDTO.getTalla()).getId();
            Catalogo catalogo = catalogoRepositorio.findByProductoIdAndTallaId(catalogoPersonalizadoDTO.getId_producto(), tallaid);
            if (catalogo != null){
                catalogo.setCantidad(catalogoPersonalizadoDTO.getCantidad());
                guardar(catalogo);
                CatalogoDTO catalogoDTO = catalogoMapper.toDTO(catalogo);
                return catalogoDTO;
            }else{
                return "No se encuentra el producto en el catalogo, por lo tanto no se le puede cambiar el stock.";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
