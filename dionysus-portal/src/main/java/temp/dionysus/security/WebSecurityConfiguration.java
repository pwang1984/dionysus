//package temp.dionysus.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import temp.dionysus.portal.customer.dao.impl.CustomerDAOImpl;
//import temp.dionysus.portal.customer.domain.Customer;
//
//@Configuration
//class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
// 
//  @Autowired
//  CustomerDAOImpl customerDAOImpl;
// 
//  @Override
//  public void init(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userDetailsService());
//  }
// 
//  @Bean
//  UserDetailsService userDetailsService() {
//    return new UserDetailsService() {
// 
//      @Override
//      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Customer customer = customerDAOImpl.getCustomerByEmail(email);
//        if(customer != null) {
//        return new User(customer.getFirstName(), customer.getPassword(), true, true, true, true,
//                AuthorityUtils.createAuthorityList("USER"));
//        } else {
//          throw new UsernameNotFoundException("could not find the user '"
//                  + email + "'");
//        }
//      }
//      
//    };
//  }
//}