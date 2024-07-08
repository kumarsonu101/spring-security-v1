package com.spring.security.config;

import com.spring.security.model.Customer;
import com.spring.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NationBankUserDetailService implements UserDetailsService {
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorites = null;

        List<Customer> customerList = customerRepository.findByEmail(username);

        if(0 == customerList.size()) {
            throw  new UsernameNotFoundException("UserDetails are not found for given user"+ username);
        }
        else {
            userName = customerList.get(0).getEmail();
            password = customerList.get(0).getPwd();
            authorites  = new ArrayList<>();

            authorites.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
        }
        return new User(username,password,authorites);

    }
}
