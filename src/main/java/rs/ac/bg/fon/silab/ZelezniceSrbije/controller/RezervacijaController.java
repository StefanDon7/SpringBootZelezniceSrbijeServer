package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.RezervacijaCompositeKey;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.RezervacijaService;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@PostMapping("/klijent/rezervacije")
	public List<Rezervacija> getRezervacijeByUserID(@RequestBody Klijent klijent) {
		return rezervacijaService.getRezervacijeByUserID(klijent.getKlijentID());
	}
	@PostMapping("/add/{klijentid}/{polazakid}")
	public Rezervacija addRezervacija(@RequestBody Klijent klijent, @RequestBody Polazak polazak) {
		Rezervacija rezervacija=new Rezervacija(new RezervacijaCompositeKey(klijent.getKlijentID(),polazak.getPolazakID()), 
												new  Klijent(klijent.getKlijentID()), 
												new Polazak(polazak.getPolazakID()), 
												new Date());
		return rezervacijaService.addRezervacija(rezervacija);
	}
	
}