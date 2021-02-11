package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import dbconnection.Connector;
import entity.Hop;

public class HopsDao implements Dao<Hop> {
	
	private String tableName = "hops";
	private String id_column = "id_hops";
	private String[] atribute = {"name", "alpha_acid", "country"};
	public List<Hop> hops = new ArrayList<>();
	private Connector connector;
//	private ResultSet hopsSet;
	
	public HopsDao(Connector c) throws SQLException {
		// TODO Auto-generated constructor stub
		connector = c;
		List<String[]> x = connector.executeSelectAll("*", tableName, atribute.length+1);
		
		for (String[] s: x) {
			Hop h = new Hop(Integer.parseInt(s[0]), s[1], s[2], s[3]);
			hops.add(h);
		}
	}
	
	@Override
	public Optional<Hop> get(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(hops.get((int) id));
	}

	@Override
	public List<Hop> getAll() {
		// TODO Auto-generated method stub
        return hops;
	}

	@Override
	public void save(Hop t) {
		// TODO Auto-generated method stub
		String[] params = {t.getName(), t.getAlphaAcid(), t.getCountry()};
		try {
			t.setId(connector.executeAddNew(tableName, id_column, atribute, params));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hops.add(t);
	}

	@Override
	public void update(Hop t, String[] params) {
		// TODO Auto-generated method stub
		t.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        t.setAlphaAcid(Objects.requireNonNull(params[1], "Alpha acid concentration cannot be null"));
        t.setCountry(Objects.requireNonNull(params[2], "Country cannot be null"));
        String[] param = {t.getName(), t.getAlphaAcid(), t.getCountry()};

        try {
			connector.executeUpdate(tableName, t.getId(), id_column, atribute, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Hop t) {
		// TODO Auto-generated method stub
		try {
			connector.executeDelete(tableName, id_column, t.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hops.remove(t);
	}	
}
