package interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import Entities.Portfolio;

@Local
public interface IPortfolioRemoteService {
	
	public int AddPortfolio (Portfolio P);
	public void DeletePortfolio(int IdPortfolio);
	public Portfolio DisplayPortfolio(int IdPortfolio);
	public List<Portfolio> DisplayPortfolios();
	public void EditPortfolio(Portfolio p);
//	public Portfolio PortfolioOptimale ();

}
