package com.develop.prd.service;

import com.develop.prd.handles.ServiceException;
import com.develop.prd.model.Role;
import com.develop.prd.repository.RoleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> list() {
        return roleRepository.findAll();
    }

    /**
     * 添加角色
     * @param role
     */
    public void addRole(Role role) {
        if(StringUtils.isBlank(role.getRoleName())) {
            throw new ServiceException("角色名称不能为空");
        }
        Optional<Role> roleOptional = roleRepository.findByRoleName(role.getRoleName());
        if(roleOptional.isPresent()) {
            throw new ServiceException("此角色已存在!");
        }else {
            role.setRoleId(UUID.randomUUID().toString());
            role.setCreateTime(new Date());
            roleRepository.save(role);
        }
    }

    /**
     * 通过id查找角色
     * @param roleId
     * @return
     */
    public Role findById(String roleId) {
        Optional<Role> optional = roleRepository.findById(roleId);
        if(optional.isPresent()) {
            return optional.get();
        }else {
            throw new ServiceException("无此角色");
        }
    }

    /**
     * 更新且保存角色
     * @param role
     */

    public void save(Role role) {
        Role dbRole = findById(role.getRoleId());
        role.setCreateTime(dbRole.getCreateTime());
        roleRepository.save(role);
    }
}
