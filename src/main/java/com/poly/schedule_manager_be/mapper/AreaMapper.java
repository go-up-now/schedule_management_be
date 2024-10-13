package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.entity.Area;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    Area toArea(AreaRequest request);
    AreaResponse toAreaResponse(Area area);

}
