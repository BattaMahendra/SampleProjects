package ms.bmc.movieinfoserv.entities;

import java.util.List;

public class MovieObj {
	
	public MovieObj() {
		
	}
	
	public MovieObj(List<Movie> cb) {
		super();
		this.cb = cb;
	}

	private List<Movie> cb;

	public List<Movie> getCb() {
		return cb;
	}

	public void setCb(List<Movie> cb) {
		this.cb = cb;
	}

}
