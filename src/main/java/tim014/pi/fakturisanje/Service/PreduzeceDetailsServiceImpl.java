package tim014.pi.fakturisanje.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim014.pi.fakturisanje.model.Preduzece;
import tim014.pi.fakturisanje.repositories.PreduzeceRepository;

import java.util.ArrayList;

@Service
public class PreduzeceDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PreduzeceRepository preduzeceRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Preduzece preduzece = preduzeceRepository.findByEmail(email);
        if(preduzece == null){
            throw new UsernameNotFoundException(email);
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("preduzece"));

        return new User(preduzece.getEmail(),preduzece.getPassword(),authorities);

    }
}
