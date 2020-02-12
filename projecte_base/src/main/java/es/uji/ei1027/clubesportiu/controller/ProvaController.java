package es.uji.ei1027.clubesportiu.controller;

import es.uji.ei1027.clubesportiu.categoria.Categoria;
import es.uji.ei1027.clubesportiu.dao.NadadorDao;
import es.uji.ei1027.clubesportiu.dao.ProvaDao;
import es.uji.ei1027.clubesportiu.model.Nadador;
import es.uji.ei1027.clubesportiu.model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prova")
public class ProvaController {

    private ProvaDao provaDao;
    @RequestMapping("/list")
    public String listProves(Model model) {
        model.addAttribute("proves", provaDao.getProves());
        return "prova/list";
    }

}