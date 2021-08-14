package com.platzi.market.persistence.mapper;


import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.comprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto",target = "idProduct"),
            @Mapping(source = "cantidad",target = "quantity"),
            @Mapping(source = "estado",target = "active"),
    })
    PurchaseItem toPurchaseItem(comprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true)
    })
    comprasProducto toComprasProducto(PurchaseItem item);
}
