package com.slide.project.demo.roles.admin;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
    private AdminRepository adminRepository;

    public AdminDetailsServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByUsername(username);
    }
    public Optional<Admin> getAdminByAdminId(long adminId)
    {
        return adminRepository.findById(adminId);//.orElseThrow(EntityNotFoundException::new); <-- ????
    }

    public long create(Admin admin) {
        return adminRepository.save(admin).getId();
    }
    public Admin create01(Admin admin) {
        return adminRepository.save(admin);
    }
}
