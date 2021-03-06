package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.PolazakRepository;

@Service
@Transactional
public class PolazakService {
	@Autowired
	private PolazakRepository polazakRepository;
	
	public List<Polazak> getAll() {
		System.out.println("Get all");
		return polazakRepository.getAll();
	}
	public List<Polazak> getAllByDate(String datum) {
		System.out.println("Get all by date");
		return polazakRepository.getAllByDate(datum);
	}
	public List<Polazak> getAllByDateStartAndFinalStation(String datum, String stanicaPocetna, String stanicaKrajnja) {
		System.out.println("Get all by date,firstStation and last Station");
		return polazakRepository.getAllByDateStartAndFinalStation(datum,stanicaPocetna,stanicaKrajnja);
	}
	
}
