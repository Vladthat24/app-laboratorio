package gob.ogti.laboratorio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gob.ogti.laboratorio.dto.ReporteGlobalActividades;
import gob.ogti.laboratorio.dto.reporteAnalisisClinicos;
import gob.ogti.laboratorio.entity.Bioquimica;
import gob.ogti.laboratorio.entity.ControlCalidad;
import gob.ogti.laboratorio.entity.Establecimiento;
import gob.ogti.laboratorio.entity.Hematologia;
import gob.ogti.laboratorio.entity.Inmunologia;
import gob.ogti.laboratorio.entity.Microbiologia;
import gob.ogti.laboratorio.entity.User;
import gob.ogti.laboratorio.service.BioquimicaService;
import gob.ogti.laboratorio.service.EstablecimientoService;
import gob.ogti.laboratorio.service.EstadoService;
import gob.ogti.laboratorio.service.HematologiaService;
import gob.ogti.laboratorio.service.InmunologiaService;
import gob.ogti.laboratorio.service.MicrobiologiaService;
import gob.ogti.laboratorio.service.RequestService;
import gob.ogti.laboratorio.service.RisService;
import gob.ogti.laboratorio.service.UserService;

@RestController
public class laboratorioController {

	@Autowired
	RequestService requestService;

	@Autowired
	EstablecimientoService es;

	@Autowired
	RisService rs;

	@Autowired
	HematologiaService hs;

	@Autowired
	BioquimicaService bs;

	@Autowired
	InmunologiaService is;

	@Autowired
	MicrobiologiaService ms;

	@Autowired
	UserService us;

	@Autowired
	EstadoService ess;

	public class MainClass {

		private MainClass() {
			throw new IllegalStateException("Utility class");
		}

		public static final String LISTA_ESTABLECIMIENTOS = "listaEstablecimientos";
		public static final String LISTA_RIS = "listaRis";
		public static final String PARAM_USUARIOLOGEADO = "usuarioLogeado";
		public static final String PARAM_USERLIST = "userList";
		public static final String PARAM_ESTADOS = "estado";

	}

	private static final Log LOG = LogFactory.getLog(laboratorioController.class);

	@RequestMapping("/hematologia")
	public ModelAndView hematologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("hematologia", new Hematologia());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET hematologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/hematologia");
		return mv;
	}

	@GetMapping("/risEsta")
	public List<Establecimiento> listaEstaRis(@RequestParam("ris") String ris) {
		return es.listaEstablecimientosRis(ris);
	}

	@PostMapping("/hematologia")
	public ModelAndView nuevoHematologia(@Valid @ModelAttribute("hematologia") Hematologia hematologia,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/GET nuevoHematologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoHematologia DATA : " + hematologia);
			hs.nuevoHematologia(hematologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("laboratorio/hematologia");
			return mv;
		} catch (Exception e) {
			LOG.info("/GET nuevoBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoBioquimica DATA : " + hematologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoHematologia ERROR : " + e.getMessage());
			mv.setViewName("laboratorio/hematologia");
			return mv;
		}

	}

	@RequestMapping("/bioquimica")
	public ModelAndView bioquimica(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("bioquimica", new Bioquimica());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET hematologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/bioquimica");
		return mv;
	}

	@PostMapping("/bioquimica")
	public ModelAndView nuevoBioquimica(@Valid @ModelAttribute("bioquimica") Bioquimica bioquimica,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/GET nuevoBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoBioquimica DATA : " + bioquimica);
			bs.nuevoBioquimica(bioquimica, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("laboratorio/bioquimica");
			return mv;
		} catch (Exception e) {
			LOG.info("/GET nuevoBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoBioquimica DATA : " + bioquimica);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoBioquimica ERROR : " + e.getMessage());
			mv.setViewName("laboratorio/bioquimica");
			return mv;

		}

	}

	@GetMapping("/inmunologia")
	public ModelAndView inmunologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("inmunologia", new Inmunologia());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET hematologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/inmunologia");
		return mv;
	}

	@PostMapping("/inmunologia")
	public ModelAndView nuevoInmunologia(@Valid @ModelAttribute("inmunologia") Inmunologia inmunologia,
			BindingResult result, Model mp, HttpServletRequest request) {

		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		try {
			

			LOG.info("/GET nuevoInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoInmunologia DATA : " + inmunologia);
			is.nuevoInmunologia(inmunologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("laboratorio/inmunologia");
			return mv;

		} catch (Exception e) {

			LOG.info("/GET nuevoInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoInmunologia DATA : " + inmunologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoInmunologia ERROR : " + e.getMessage());
			mv.setViewName("laboratorio/inmunologia");
			return mv;
		}

	}

	@GetMapping("/microbiologia")
	public ModelAndView microbiologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("microbiologia", new Microbiologia());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET microbiologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/microbiologia");
		return mv;
	}

	@PostMapping("/microbiologia")
	public ModelAndView nuevoMicrobiologia(@Valid @ModelAttribute("microbiologia") Microbiologia microbiologia,
			BindingResult result, Model mp, HttpServletRequest request) {

		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		try {

			LOG.info("/GET nuevoMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMicrobiologia DATA : " + microbiologia);
			ms.nuevoMicrobiologia(microbiologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("laboratorio/microbiologia");
			return mv;

		} catch (Exception e) {

			LOG.info("/GET nuevoMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMicrobiologia DATA : " + microbiologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoMicrobiologia ERROR : " + e.getMessage());
			mv.setViewName("laboratorio/microbiologia");
			return mv;
		}

	}

	@GetMapping("/controlCalidad")
	public ModelAndView controlCalidad(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("controlCalidad", new ControlCalidad());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET controlCalidad IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/controlCalidad");
		return mv;
	}

	@PostMapping("/controlCalidad")
	public ModelAndView controlCalidad(@Valid @ModelAttribute("controlCalidad") ControlCalidad controlCalidad,
			BindingResult result, Model mp, HttpServletRequest request) {

		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		try {

			LOG.info("/GET nuevoMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMicrobiologia DATA : " + controlCalidad);
			hs.nuevoControlCalidad(controlCalidad, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("laboratorio/controlCalidad");
			return mv;

		} catch (Exception e) {

			LOG.info("/GET nuevoMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMicrobiologia DATA : " + controlCalidad);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoMicrobiologia ERROR : " + e.getMessage());
			mv.setViewName("laboratorio/controlCalidad");
			return mv;
		}

	}

	@GetMapping("/conExaCli")
	public ModelAndView conExaCli(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET microbiologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/conExaCli");
		return mv;
	}

	@GetMapping("/dashExaCli")
	public ModelAndView dashExaCli(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET dashExaCli IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("reportes/dashExaCli");
		return mv;
	}

	@GetMapping("/reporteBioquimica")
	public List<Object[]> reporteBioquimica(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {

		LOG.info("/GET reporteBioquimica año : " + ano + " mes : " + mes + " mes2: " + mes2);

		return bs.reporteBioquimica(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteHematologia")
	List<Object[]> reporteHematologia(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return hs.reporteHematologia(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteInmunologia")
	List<Object[]> reporteInmunologia(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return is.reporteInmunologia(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteMicrobiologia")
	List<Object[]> reporteMicrobiologia(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return ms.reporteMicrobiologia(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteAnalisisTotal")
	List<Object[]> reporteAnalisisTotal(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return bs.reporteAnalisisTotal(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteControlCalidad")
	List<Object[]> reporteControlCalidad(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return hs.reporteControlCalidad(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteConsololidad")
	List<Object[]> reporteConsololidad() {
		return bs.reporteConsololidad();
	}

	@GetMapping("/listaBioquimica")
	public ModelAndView listaBioquimica(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET dashExaCli IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaBioquimica");
		return mv;
	}

	@PostMapping("/listaBioquimica")
	public ModelAndView listaBioquimica2(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaBioquimica2 IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("bioquimica", bs.listaBioquimica(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaBioquimica");
		return mv;
	}

	@GetMapping("/editarBioquimica/{id}")
	public ModelAndView editarBioquimica(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("bioquimica", bs.buscarBioquimica(id));
			LOG.info("/GET editarBioquimica data : " + bs.buscarBioquimica(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("laboratorio/editarBioquimica");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("laboratorio/listaBioquimica");
			return mv;
		}

	}

	@PostMapping("/editarBioquimica")
	public ModelAndView editarBioquimica(@Valid @ModelAttribute("bioquimica") Bioquimica bioquimica,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarBioquimica DATA : " + bioquimica);
			bs.editarBioquimica(bioquimica, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaBioquimica");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarBioquimica IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarBioquimica DATA : " + bioquimica);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarBioquimica ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaBioquimica");
			return mv;

		}

	}

	@GetMapping("/listaHematologia")
	public ModelAndView listaHematologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaHematologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaHematologia");
		return mv;
	}

	@PostMapping("/listaHematologia")
	public ModelAndView listaHematologia2(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaHematologia2 IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("hematologia", hs.listaHematologia(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaHematologia");
		return mv;
	}

	@GetMapping("/editarHematologia/{id}")
	public ModelAndView editarHematologia(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("hematologia", hs.buscarHematologia(id));
			LOG.info("/GET editarHematologia data : " + hs.buscarHematologia(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarHematologia IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("laboratorio/editarHematologia");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("laboratorio/editarHematologia");
			return mv;
		}

	}

	@PostMapping("/editarHematologia")
	public ModelAndView editarHematologia(@Valid @ModelAttribute("hematologia") Hematologia hematologia,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarHematologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarHematologia DATA : " + hematologia);
			hs.editarHematologia(hematologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaHematologia");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarHematologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarHematologia DATA : " + hematologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarHematologia ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaHematologia");
			return mv;

		}

	}

	@GetMapping("/listaInmunologia")
	public ModelAndView listaInmunologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaInmunologia");
		return mv;
	}

	@PostMapping("/listaInmunologia")
	public ModelAndView listaInmunologia(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("inmunologia", is.listaInmunologia(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaInmunologia");
		return mv;
	}

	@GetMapping("/editarInmunologia/{id}")
	public ModelAndView editarInmunologia(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("inmunologia", is.buscarInmunologia(id));
			LOG.info("/GET editarInmunologia data : " + is.buscarInmunologia(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("laboratorio/editarInmunologia");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("redirect:/listaInmunologia");
			return mv;
		}

	}

	@PostMapping("/editarInmunologia")
	public ModelAndView editarInmunologia(@Valid @ModelAttribute("inmunologia") Inmunologia inmunologia,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarInmunologia DATA : " + inmunologia);
			is.editarInmunologia(inmunologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaInmunologia");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarInmunologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarInmunologia DATA : " + inmunologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarInmunologia ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaInmunologia");
			return mv;

		}

	}

	@GetMapping("/listaMicrobiologia")
	public ModelAndView listaMicrobiologia(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaMicrobiologia");
		return mv;
	}

	@PostMapping("/listaMicrobiologia")
	public ModelAndView listaMicrobiologia(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("microbiologia", ms.listaMicrobiologia(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaMicrobiologia");
		return mv;
	}

	@GetMapping("/editarMicrobiologia/{id}")
	public ModelAndView editarMicrobiologia(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("microbiologia", ms.buscarMicrobiologia(id));
			LOG.info("/GET editarMicrobiologia data : " + ms.buscarMicrobiologia(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("laboratorio/editarMicrobiologia");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("redirect:/listaMicrobiologia");
			return mv;
		}

	}

	@PostMapping("/editarMicrobiologia")
	public ModelAndView editarMicrobiologia(@Valid @ModelAttribute("microbiologia") Microbiologia microbiologia,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarMicrobiologia DATA : " + microbiologia);
			ms.editarMicrobiologia(microbiologia, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaMicrobiologia");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarMicrobiologia IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarMicrobiologia DATA : " + microbiologia);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarMicrobiologia ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaMicrobiologia");
			return mv;

		}

	}

	@GetMapping("/listaControlCalidad")
	public ModelAndView listaControlCalidad(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaControlCalidad IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaControlCalidad");
		return mv;
	}

	@PostMapping("/listaControlCalidad")
	public ModelAndView listaControlCalidad(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaControlCalidad IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("controlCalidad", hs.listaControlCalidad(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("laboratorio/listaControlCalidad");
		return mv;
	}

	@GetMapping("/editarControl/{id}")
	public ModelAndView editarControl(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("controlCalidad", hs.buscarControl(id));
			LOG.info("/GET editarControl data : " + hs.buscarControl(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarControl IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("laboratorio/editarControl");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("redirect:/listaControlCalidad");
			return mv;
		}

	}

	@PostMapping("/editarControl")
	public ModelAndView editarControl(@Valid @ModelAttribute("controlCalidad") ControlCalidad controlCalidad,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarControl IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarControl DATA : " + controlCalidad);
			hs.editarControl(controlCalidad, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaControlCalidad");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarControl IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarControl DATA : " + controlCalidad);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarControl ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaControlCalidad");
			return mv;

		}

	}

	@GetMapping("/reporteTotAct")
	List<ReporteGlobalActividades> reporteTotAct(@RequestParam("ano") String ano, @RequestParam("esta") String esta,
			@RequestParam("mes") String mes, @RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return bs.reporteTotAct(ris, esta, mes, mes2, ano);
	}

	@GetMapping("/consResultados")
	public ModelAndView consResultados(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET consResultados IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.LISTA_ESTABLECIMIENTOS, es.listaEstablecimientos());

		mv.setViewName("reportes/consResultados");
		return mv;
	}

	@PostMapping("/consResultados")
	public ModelAndView consResultados(@RequestParam("ano") String ano, @RequestParam("esta") String esta,
			@RequestParam("mes") String mes, @RequestParam("mes2") String mes2, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		String ris = es.buscarRisEsta(esta);
		String nomEsta = es.buscarNomEsta(esta);

		try {
			LOG.info("/POST consResultados IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST consResultados DATA : " + bs.reporteTotAct(ris, esta, mes, mes2, ano));
			mp.addAttribute("listaReTotAct", bs.reporteTotAct(ris, esta, mes, mes2, ano));
			mp.addAttribute("tablaAnalisisClinicos", bs.tablaAnalisisClinicos(ris, esta, mes, mes2, ano));
			mp.addAttribute("anob", ano);
			mp.addAttribute("nomEstab", nomEsta);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.LISTA_ESTABLECIMIENTOS, es.listaEstablecimientos());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("reportes/consResultados");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST consResultados IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.LISTA_ESTABLECIMIENTOS, es.listaEstablecimientos());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST consResultados ERROR : " + e.getMessage());
			mv.setViewName("redirect:/consResultados");
			return mv;

		}

	}

	@GetMapping("/tablaAnalisisClinicos")
	List<reporteAnalisisClinicos> tablaAnalisisClinicos(@RequestParam("ano") String ano,
			@RequestParam("esta") String esta, @RequestParam("mes") String mes, @RequestParam("ris") String ris,
			@RequestParam("mes2") String mes2) {
		return bs.tablaAnalisisClinicos(ris, esta, mes, mes2, ano);
	}

}
