package org.api.demo.Security;

import org.api.demo.Model.Usuario;
import org.api.demo.Repository.TodoRepository;
import org.api.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Usuario usuario = userRepository
                    .findOneByEmail(email)
                    .orElseThrow(()-> new UsernameNotFoundException("El Usuario no existe"));
        return new UserDetailsImpl(usuario);
    }

    
}
