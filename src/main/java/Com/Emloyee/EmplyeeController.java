package Com.Emloyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class EmplyeeController {
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value ="/admin") //admin url for accessing Display Page
	public ModelAndView register() {
		{
			System.out.println("hi");
			return new ModelAndView("Display");
		}
	}
	
	
	@RequestMapping(value ="/authenticate", method = RequestMethod.POST)//method for generate jwttoken
	 public String generateToken(@RequestBody AuthRequest authreq) throws Exception {
		
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authreq.getUsername(),authreq.getPassword())
	            );
	            
	        } catch (Exception ex) {
	        	
	            throw new Exception("inavalid username/password");
	        }
	        
	        return jwtutil.generateToken(authreq.getUsername());
	       
	    }
	
}
