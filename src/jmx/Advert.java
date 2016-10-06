package jmx;
import dao.AdvertDao;

public class Advert implements AdvertMBean {

	@Override
	public int getCount() {
		AdvertDao dao = new AdvertDao();
		return dao.countAdverts();
		
	}

	@Override
	public void reset() {
		AdvertDao dao = new AdvertDao();
		dao.deleteAll();
	}

}
