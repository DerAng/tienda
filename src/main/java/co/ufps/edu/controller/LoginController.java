package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.dto.Login;

@Controller
public class LoginController {

	private LoginDao loginDao;
	
	public LoginController(){
		loginDao=new LoginDao();
	}
	
	@ModelAttribute("login")
	public Login setUpUserForm() {
		return new Login();
	}
	
	
	@GetMapping("admin") // Base
	public String indexAdmin() {
		return "/Administrador/indexAdmin"; // Nombre del archivo jsp
	}
	
	@GetMapping("/login") // Base
	public String index() {
		return "Login"; // Nombre del archivo jsp
	}
	
	@PostMapping("/autenticar")
	public String authenticateUser(@ModelAttribute("login") Login login, Model model, HttpServletRequest request) {

		if(!StringUtils.isEmpty(login.getCorreoElectronico()) && !StringUtils.isEmpty(login.getContraseña())) {
			String resultado = loginDao.authenticate(login.getCorreoElectronico(), login.getContraseña());
			
			if (!resultado.isEmpty()) {
				/*String jwt = jwtUtil.generateToken(resultado, String.valueOf(login.getCodigo()));
				request.setAttribute("token", jwt);
				request.getSession().setAttribute("codigo", login.getCodigo());
				HttpSession session = request.getSession();
				template.opsForValue().set("SESSION:" + login.getCodigo(), jwt);
				session.setAttribute("codigo", login.getCodigo());*/
				if (resultado.equals("admin")) {
					//session.setAttribute("user", "Administrador");
					return "Administrador/indexAdmin";
				}
			}else {
				model.addAttribute("wrong", "Usuario o contraseña incorrectos.");	
			}
			return "Login";
		}else {
			model.addAttribute("wrong", "El usuario y la contraseña no pueden ser nulos.");	
			return "Login";
		}
	}
}


