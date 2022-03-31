package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.entity.ERole;
import com.project3.revtech.entity.RoleEntity;
import com.project3.revtech.entity.UserEntity;

import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");
        Optional<UserEntity> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals("42 Main St", ((UserDetailsImpl) actualLoadUserByUsernameResult).getAddress());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1, ((UserDetailsImpl) actualLoadUserByUsernameResult).getUser_id());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("Doe", ((UserDetailsImpl) actualLoadUserByUsernameResult).getLast_name());
        assertEquals("Jane", ((UserDetailsImpl) actualLoadUserByUsernameResult).getFirst_name());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("Contact", ((UserDetailsImpl) actualLoadUserByUsernameResult).getContact());
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.userRepository.findByUsername((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> this.userDetailsServiceImpl.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        RoleEntity role = new RoleEntity();
        role.setId(1);
        role.setName(ERole.ROLE_USER);

        HashSet<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(role);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(roleSet);
        user.setUserId(1);
        user.setUsername("janedoe");
        Optional<UserEntity> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals("42 Main St", ((UserDetailsImpl) actualLoadUserByUsernameResult).getAddress());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1, ((UserDetailsImpl) actualLoadUserByUsernameResult).getUser_id());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("Doe", ((UserDetailsImpl) actualLoadUserByUsernameResult).getLast_name());
        assertEquals("Jane", ((UserDetailsImpl) actualLoadUserByUsernameResult).getFirst_name());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("Contact", ((UserDetailsImpl) actualLoadUserByUsernameResult).getContact());
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("ROLE_USER", ((List<? extends GrantedAuthority>) authorities).get(0).getAuthority());
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        RoleEntity role = new RoleEntity();
        role.setId(1);
        role.setName(ERole.ROLE_USER);

        RoleEntity role1 = new RoleEntity();
        role1.setId(1);
        role1.setName(ERole.ROLE_USER);

        HashSet<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(role1);
        roleSet.add(role);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(roleSet);
        user.setUserId(1);
        user.setUsername("janedoe");
        Optional<UserEntity> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals("42 Main St", ((UserDetailsImpl) actualLoadUserByUsernameResult).getAddress());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1, ((UserDetailsImpl) actualLoadUserByUsernameResult).getUser_id());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("Doe", ((UserDetailsImpl) actualLoadUserByUsernameResult).getLast_name());
        assertEquals("Jane", ((UserDetailsImpl) actualLoadUserByUsernameResult).getFirst_name());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("Contact", ((UserDetailsImpl) actualLoadUserByUsernameResult).getContact());
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(2, authorities.size());
        assertEquals("ROLE_USER", ((List<? extends GrantedAuthority>) authorities).get(0).toString());
        assertEquals("ROLE_USER", ((List<? extends GrantedAuthority>) authorities).get(1).toString());
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername5() throws UsernameNotFoundException {
        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> this.userDetailsServiceImpl.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }
}

