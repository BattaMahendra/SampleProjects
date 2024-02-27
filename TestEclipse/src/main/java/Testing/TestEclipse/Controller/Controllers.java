package Testing.TestEclipse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This project is a Resource server 
 * we have implemented Okta Auth server in it.
 * if we want to access this app's endpoints we need access token from Okta auth server.
 */
@RestController
@RequestMapping("/m")
public class Controllers {

	/*
	 * we have activated OAuth 2.0 for this endpoint
	 * in order for this API to work we need access token from the Okta Authorization server
	 * other wise you will get 401  error which signifies we need access token form Okta auth server for this end point to work
	 * I have created a Okta authorization server and details of it are 
	 * Client-id : 0oa9jlr1h0HmaqI0P5d7
	 * client -secret : D5fN6kGCNvrR7i5lJdjEbleSS_9BP0yipNnX8Jvz
	 * Auth-server issuer-uri:https://dev-59927831.okta.com/oauth2/default
	 * aud :api://default
	 * 
	 * 
	 * now for this endpoint to work first we have to hit url with some authorization as follows
	 * https://dev-59927831.okta.com/oauth2/default/v1/token (issuerUri/v1/token) 
	 * with authorisation as username:client-id(public key mentioned above)
	 * and password :client-secret (mentioned above)
	 * and now go to body --> x-www-form-urlencoded ---> add below two fields
	 * 		KEY                    VALUE
	 *     grant_type              client_credentials
	 *     scope                   mahendra (which we have set in the Okta configuration)
	 *     
	 *     now if u hit this uri , you will get the access token with Bearer and scope we have set.
	 *     take that access token without double colons and use it in our endpoint(localhost:8080/m/s)
	 *     how to use is go to Authorisation in postman ---> Bearer token ---> add the token which u copied form okta authorisation server resopnse
	 *     now you will be able to acccess this below endpoint.
	 *     
	 *     created token --> 00xv6voXn8sfvKY4UBeKQ5tt49N6_L9HwbyBOaOiJg
	 */
	@GetMapping("/s")
	public String sayHello() {
		return "Hello Mahendra";
	}
}
