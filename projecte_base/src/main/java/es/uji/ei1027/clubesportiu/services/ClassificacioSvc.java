package es.uji.ei1027.clubesportiu.services;

import es.uji.ei1027.clubesportiu.dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.dao.NadadorDao;
import es.uji.ei1027.clubesportiu.model.Classificacio;
import es.uji.ei1027.clubesportiu.model.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassificacioSvc implements ClassificacioService {

    @Autowired
    NadadorDao nadadorDao;

    @Autowired
    ClassificacioDao classificacioDao;

    @Override
    public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
        List<Classificacio> classProva = classificacioDao.getClassificacioProva(prova);
        HashMap<String,List<Nadador>> nadadorsPerPais = new HashMap<>();
        for (Classificacio clsf : classProva) {
            Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
            if (!nadadorsPerPais.containsKey(nadador.getPais())) {
                nadadorsPerPais.put(nadador.getPais(), new ArrayList<>());
            }
            nadadorsPerPais.get(nadador.getPais()).add(nadador);
        }
        return nadadorsPerPais;
    }

    @Override
    public Map<String, List<Nadador>> getClassificationByEvent(String pais) {
        List<Classificacio> classPais = classificacioDao.getClassificacioPais(pais);
        HashMap<String, List<Nadador>> nadadorsPerProva = new HashMap<>();
        for (Classificacio clsf : classPais){
            Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
            if (!nadadorsPerProva.containsKey(clsf.getNomProva())){
                nadadorsPerProva.put(clsf.getNomProva(),new ArrayList<>());
            }
            nadadorsPerProva.get(clsf.getNomProva()).add(nadador);
        }
        return nadadorsPerProva;
    }
}
