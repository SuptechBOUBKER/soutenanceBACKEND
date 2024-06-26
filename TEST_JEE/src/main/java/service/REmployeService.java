package service;

import java.util.List;

import DAO.REmployeDao;
import entities.REmploye;

public class REmployeService {
	REmployeDao remployeDao;
	public REmployeService() {
		remployeDao=new REmployeDao();
	}

	public REmploye addREmploye(REmploye remploye) {
		return remployeDao.addREmploye(remploye);
	}
	public List<REmploye> getAllREmployes(){
		return remployeDao.getAllREmployes();
	}
	public void deleteREmploye(REmploye remploye) {
		remployeDao.deleteREmploye(remploye);
	}
}

