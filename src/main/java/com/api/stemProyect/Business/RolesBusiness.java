package com.api.stemProyect.Business;

import com.api.stemProyect.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolesBusiness {
    @Autowired
    RolesService rolesService;


}
