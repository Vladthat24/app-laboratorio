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

import gob.ogti.laboratorio.controller.laboratorioController.MainClass;
import gob.ogti.laboratorio.entity.MuestrasDerivadasIns;
import gob.ogti.laboratorio.entity.TomaPruebaCovid19;
import gob.ogti.laboratorio.entity.User;
import gob.ogti.laboratorio.service.EstablecimientoService;
import gob.ogti.laboratorio.service.EstadoService;
import gob.ogti.laboratorio.service.MuestrasDeribadasInsService;
import gob.ogti.laboratorio.service.RequestService;
import gob.ogti.laboratorio.service.RisService;
import gob.ogti.laboratorio.service.TomaMuestraCovid19Service;
import gob.ogti.laboratorio.service.UserService;

@RestController
public class muestrasController {

	@Autowired
	RequestService requestService;

	@Autowired
	EstablecimientoService es;

	@Autowired
	RisService rs;

	@Autowired
	UserService us;

	@Autowired
	EstadoService ess;

	@Autowired
	MuestrasDeribadasInsService mdis;

	@Autowired
	TomaMuestraCovid19Service tmcs;

	private static final Log LOG = LogFactory.getLog(muestrasController.class);

	@RequestMapping("/ins")
	public ModelAndView ins(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("ins", new MuestrasDerivadasIns());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET hematologia IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/muestrasIns");
		return mv;
	}

	@PostMapping("/ins")
	public ModelAndView nuevoIns(@Valid @ModelAttribute("ins") MuestrasDerivadasIns ins, BindingResult result, Model mp,
			HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/GET nuevoIns IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoIns DATA : " + ins);
			mdis.nuevoMuestraDerivadaIns(ins, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("muestras/muestrasIns");
			return mv;
		} catch (Exception e) {
			LOG.info("/GET nuevoIns IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoIns DATA : " + ins);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoIns ERROR : " + e.getMessage());
			mv.setViewName("muestras/muestrasIns");
			return mv;
		}

	}

	@RequestMapping("/mpcovid19")
	public ModelAndView mpcovid19(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		mp.addAttribute("mpcovid19", new TomaPruebaCovid19());
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET mpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/mpcovid19");
		return mv;
	}

	@PostMapping("/mpcovid19")
	public ModelAndView nuevoMpcovid19(@Valid @ModelAttribute("mpcovid19") TomaPruebaCovid19 mpcovid19,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/GET nuevoMpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMpcovid19 DATA : " + mpcovid19);
			tmcs.nuevoTomaMuestraCovid19(mpcovid19, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("muestras/mpcovid19");
			return mv;
		} catch (Exception e) {
			LOG.info("/GET nuevoMpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/GET nuevoMpcovid19 DATA : " + mpcovid19);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/GET nuevoMpcovid19 ERROR : " + e.getMessage());
			mv.setViewName("muestras/mpcovid19");
			return mv;
		}

	}

	@GetMapping("/reporteMuestrasDeribadas")
	List<Object[]> reporteMuestrasDeribadas(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return mdis.reporteMuestrasDeribadas(ano, mes, ris, mes2);
	}

	@GetMapping("/reporteTomaMuestrasCovid19")
	List<Object[]> reporteTomaMuestrasCovid19(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return tmcs.reporteTomaMuestrasCovid19(ano, mes, ris,mes2);
	}

	@GetMapping("/reporteRegistroSisCovid19")
	List<Object[]> reporteRegistroSisCovid19(@RequestParam("ano") String ano, @RequestParam("mes") String mes,
			@RequestParam("ris") String ris, @RequestParam("mes2") String mes2) {
		return tmcs.reporteRegistroSisCovid19(ano, mes, ris, mes2);
	}

	@GetMapping("/listaIns")
	public ModelAndView listaIns(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaIns IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/listaIns");
		return mv;
	}

	@PostMapping("/listaIns")
	public ModelAndView listaIns(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaIns IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("listaIns", mdis.listaIns(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/listaIns");
		return mv;
	}

	@GetMapping("/editarIns/{id}")
	public ModelAndView editarIns(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("ins", mdis.buscarIns(id));
			LOG.info("/GET editarIns data : " + mdis.buscarIns(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarIns IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("muestras/editarIns");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("redirect:/listaIns");
			return mv;
		}

	}

	@PostMapping("/editarIns")
	public ModelAndView editarIns(@Valid @ModelAttribute("ins") MuestrasDerivadasIns ins, BindingResult result,
			Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarIns IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarIns DATA : " + ins);
			mdis.editarIns(ins, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaIns");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarIns IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarIns DATA : " + ins);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarIns ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaIns");
			return mv;

		}

	}

	@GetMapping("/listaMpcovid19")
	public ModelAndView listaMpcovid19(Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaIns IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/listaMpcovid19");
		return mv;
	}

	@PostMapping("/listaMpcovid19")
	public ModelAndView listaMpcovid19(Model mp, HttpServletRequest request, @RequestParam("ano") String ano,
			@RequestParam("mes") String mes) {
		User u = us.getLoggedUser();

		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);
		LOG.info("/GET listaIns IP : " + clientIp + " usuario : " + u.getUsername());
		mp.addAttribute("listaMpcovid19", tmcs.listaMpcovid19(ano, mes));
		mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
		mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getEstablecimiento().getRis().getCodRis());
		mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
		mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());

		mv.setViewName("muestras/listaMpcovid19");
		return mv;
	}

	@GetMapping("/editarMpcovid19/{id}")
	public ModelAndView editarMpcovid19(@PathVariable("id") long id, ModelMap mp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			mp.addAttribute("mpcovid19", tmcs.buscarMpcovid19(id));
			LOG.info("/GET editarMpcovid19 data : " + mdis.buscarIns(id));
			User u = us.getLoggedUser();

			String clientIp = requestService.getClientIp(request);
			LOG.info("/GET editarMpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
			mp.addAttribute(MainClass.LISTA_RIS, rs.listaRis());
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("muestras/editarMpcovid19");
			return modelAndView;
		} catch (Exception e) {
			e.getMessage();
			mv.setViewName("redirect:/listaMpcovid19");
			return mv;
		}

	}

	@PostMapping("/editarMpcovid19")
	public ModelAndView editarMpcovid19(@Valid @ModelAttribute("mpcovid19") TomaPruebaCovid19 mpcovid19,
			BindingResult result, Model mp, HttpServletRequest request) {
		User u = us.getLoggedUser();
		ModelAndView mv = new ModelAndView();
		String clientIp = requestService.getClientIp(request);

		try {
			LOG.info("/POST editarMpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.info("/POST editarMpcovid19 DATA : " + mpcovid19);
			tmcs.editarMpcovid19(mpcovid19, clientIp);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", "Se agrego exitosamente");
			mv.setViewName("redirect:/listaMpcovid19");
			return mv;
		} catch (Exception e) {
			LOG.error("/POST editarMpcovid19 IP : " + clientIp + " usuario : " + u.getUsername());
			LOG.error("/POST editarMpcovid19 DATA : " + mpcovid19);
			mp.addAttribute(MainClass.PARAM_USUARIOLOGEADO, u.getUsername());
			mp.addAttribute(MainClass.PARAM_USERLIST, us.getAllUsers());
			mp.addAttribute(MainClass.PARAM_ESTADOS, ess.estados());
			mp.addAttribute("mensaje", e.getMessage());
			LOG.error("/POST editarMpcovid19 ERROR : " + e.getMessage());
			mv.setViewName("redirect:/listaMpcovid19");
			return mv;

		}

	}

}
