//package com.ronalds.inventory_project.service;
//
//import com.ronalds.inventory_project.dao.ClientRepository;
//import com.ronalds.inventory_project.dao.RoleRepository;
//import com.ronalds.inventory_project.entity.Client;
//import com.ronalds.inventory_project.entity.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private ClientService clientService;
//
//    private RoleRepository roleRepository;
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserDetailsServiceImpl(ClientService clientService, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
//        this.clientService = clientService;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Client client = this.clientService.findByUsername(userName);
//
//        if (client == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
//
////        System.out.println("Found User: " + client);
////
////        // [ROLE_USER, ROLE_ADMIN,..]
////
////        List<String> roleNames = new ArrayList<>();
////
////        for (Role roles: client.getRoles()
////             ) {
////            roleNames.add(roles.toString());
////        }
//////        List<String> roleNames;
//////        = client.getRoles().;
//////        (client.getId());
////
////        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
////        if (roleNames != null) {
////            for (String role : roleNames) {
////                // ROLE_USER, ROLE_ADMIN,..
////                GrantedAuthority authority = new SimpleGrantedAuthority(role);
////                grantList.add(authority);
////            }
////        }
//
//        UserDetails userDetails = (UserDetails) new User(client.getUsername(), //
//                client.getPassword(), grantList);
//
//        return userDetails;
//
//    }
//}
