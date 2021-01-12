package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.RezervacijaCompositeKey;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.RezervacijaRepository;

@Service
@Transactional
public class RezervacijaService {

	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	public List<Rezervacija> getRezervacijeByUserID(int klijentid) {
		return this.rezervacijaRepository.getRezervacijeByUserID(klijentid);
	}
	
	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		return this.rezervacijaRepository.save(rezervacija);
	}
}