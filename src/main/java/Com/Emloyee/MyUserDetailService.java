package Com.Emloyee;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;



@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //fetch username from database
		
	
		Employee user= userepository.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		return new MyUserDetails(user);
	}

}
