package org.example.labanalyse;

import org.example.labanalyse.entites.*;
import org.example.labanalyse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class LabAnalyseApplication {

    @Autowired
    PatientRepository  patientrepository;
    @Autowired
    EchantillonRepository echantillonRepository;
    @Autowired
    AnalyseRepository analyseRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PlanificationRepository planificationRepository;
    @Autowired
    private ReactiveRepository reactiveRepository;
    @Autowired
    private  TypeTestRepository typeTestRepository;


    public static void main(String[] args) {

        SpringApplication.run(LabAnalyseApplication.class, args);
    }
   @PostConstruct
   @Transactional
   public void run() {
       // Création et sauvegarde d'un Patient
       Patient patient = new Patient();
       patient.setName("John Doe");
       patient.setDatenaissnce(new Date());
       patient.setAdresse("123 Main Street");
       patient.setTel("123-456-7890");
       patientrepository.save(patient);


       // Création et sauvegarde d'un Patient
       // Création et sauvegarde d'un Echantillon
       Echantillon echantillon = new Echantillon();
       echantillon.setPatient(patient);
       echantillon.setTypeanalyse("biochimie");
       echantillon.setStatus(StatusEchan.cours);
       echantillon.setDateprelevement(new Date());
       echantillonRepository.save(echantillon);


       // Création et sauvegarde d'une Analyse
       Analyse analyse = new Analyse();
       analyse.setEchantillon(echantillon);
       analyse.setTechnicieen("Technician");
       analyse.setDate_debut_analyse(new Date());
       analyse.setDate_fin_analyse(new Date());
       analyse.setResultats(StatusResult.normal);

       analyseRepository.save(analyse);


       //cration test
       Test test = new Test();
       test.setName("tdv");
       test.setResultattest(34.23);
       test.setAnalyse(analyse);

       testRepository.save(test);


       // Création d'une Planification
       Planification planification = new Planification();
       planification.setDatedebut(new Date());
       planification.setDatefin(new Date());
       planification.setAnalyse(analyse);



       // Enregistrement de la planification dans la base de données
       planificationRepository.save(planification);
       analyse.setPlanification(planification);
       analyseRepository.save(analyse);

       // Création d'un utilisateur
       User user = new User();
       user.setName("kawtar");
       user.setMotpasse("password");
       user.setInformationpersonelle("Some information");

       // Association de l'utilisateur à la planification
       user.setPlanification(planification);

       // Enregistrement de l'utilisateur dans la base de données
       userRepository.save(user);



// Création d'un réactif
       Reactive reactive = new Reactive();
       reactive.setName("Reactive1");
       reactive.setDescription("Description");
       reactive.setDateexperation(new Date());
       reactive.setQuantitestock(100);
       reactive.setFournisseur("Supplier");

       // Enregistrement du réactif dans la base de données
       reactiveRepository.save(reactive);
       analyse.setReactive(reactive);
       analyseRepository.save(analyse);
       // Création d'un type de test
       TypeTest typeTest = new TypeTest();
       typeTest.setMin(40.0);
       typeTest.setMax(60.0);

       // Association du type de test au test
       typeTest.setTest(test);

       // Enregistrement du type de test dans la base de données
       typeTestRepository.save(typeTest);




       // Récupération de toutes les analyses
           List<Analyse> analyses = analyseRepository.findAll();
           System.out.println("^______list des analyse____________");
           for (Analyse a : analyses) {
               System.out.println("Analyse ID: " + a.getId() + ", Resultat: " + a.getResultats());
           }


       }


   }
