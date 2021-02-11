package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.Dao;
import dao.HopsDao;
import dbconnection.Connector;
import entity.Hop;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHopsDao {

	static Dao<Hop> hopsDao;
	static DaneHopDao daneHop;
	static Connector c;
	int d;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new Connector();
		hopsDao = new HopsDao(c);
		daneHop = new DaneHopDao();
	}
	
	@Test
	public final void test1() throws SQLException {
		List<Hop> result = hopsDao.getAll();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getName());
		}
		List<String[]> x = c.executeSelectAll("*", "hops", 4);
		
		List<Hop> y = new ArrayList<Hop>();
		for (String[] s: x) {
			Hop h = new Hop(Integer.parseInt(s[0]), s[1], s[2], s[3]);
			y.add(h);
		}
		
		for (int i = 0; i < y.size(); i++) {

			assertEquals(result.get(i).getId(), y.get(i).getId());
			assertEquals(result.get(i).getName(), y.get(i).getName());
			assertEquals(result.get(i).getAlphaAcid(), y.get(i).getAlphaAcid());
			assertEquals(result.get(i).getCountry(), y.get(i).getCountry());
		}
	}
	
	@Test
	public final void test2() throws SQLException {
		Hop result = hopsDao.get(2).get();
		List<String[]> x = c.executeSelectAll("*", "hops", 4);
		Hop y = null;

		y = new Hop(Integer.parseInt(x.get(2)[0]), x.get(2)[1], x.get(2)[2], x.get(2)[3]);

		assertEquals(result.getId(), y.getId());
		assertEquals(result.getName(), y.getName());
		assertEquals(result.getAlphaAcid(), y.getAlphaAcid());
		assertEquals(result.getCountry(), y.getCountry());
	}
	
	@Test
	public final void test3() throws SQLException {
		hopsDao.save(daneHop.hop);
		Hop result = hopsDao.get(hopsDao.getAll().size()-1).get();
		
		String[] x = c.executeSelectAll("*", "hops ORDER BY id_hops DESC LIMIT 1", 4).get(0);
				
		Hop y = new Hop(Integer.parseInt(x[0]), x[1], x[2], x[3]);

		assertEquals(result.getId(), y.getId());
		assertEquals(result.getName(), y.getName());
		assertEquals(result.getAlphaAcid(), y.getAlphaAcid());
		assertEquals(result.getCountry(), y.getCountry());
		
		d = JOptionPane.showConfirmDialog(null, "Sprawd� dane w MySql", "Sprawd� dane w MySql", JOptionPane.YES_NO_OPTION);
		assertTrue(d == 0);
	}
	
	@Test
	public final void test4() throws SQLException {
		if (d == 0) {
			List<Hop> hl = hopsDao.getAll();
			Hop h = hl.get(hl.size()-1);
			hopsDao.update(h, daneHop.TxtUp);
			hl = hopsDao.getAll();
			
			Hop result = hl.get(hl.size()-1);
			Hop y = new Hop(h.getId(), daneHop.TxtUp[0], daneHop.TxtUp[1], daneHop.TxtUp[2]);
			assertEquals(result.getId(), y.getId());
			assertEquals(result.getName(), y.getName());
			assertEquals(result.getAlphaAcid(), y.getAlphaAcid());
			assertEquals(result.getCountry(), y.getCountry());
			d = JOptionPane.showConfirmDialog(null, "Sprawd� dane w MySql", "Sprawd� dane w MySql", JOptionPane.YES_NO_OPTION);
			assertTrue(d == 0);
		}
		else
			assertTrue(d == 0);
	}
	
	@Test
	public final void test5() throws SQLException {
		if (d == 0) {
			List<Hop> hl = hopsDao.getAll();
			Hop h = hl.get(hl.size()-1);
			hopsDao.delete(h);
			
			System.out.println("==============");
			List<Hop> result = hopsDao.getAll();
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i).getName());
			}

			List<String[]>  x = c.executeSelectAll("*", "hops", 4);
			
			List<Hop> y = new ArrayList<Hop>();
			for (String[] s: x) {
				Hop hop = new Hop(Integer.parseInt(s[0]), s[1], s[2], s[3]);
				y.add(hop);
			}
						
			d = JOptionPane.showConfirmDialog(null, "Sprawd� dane w MySql", "Sprawd� dane w MySql", JOptionPane.YES_NO_OPTION);
			assertTrue(d == 0);
			
			for (int i = 0; i < y.size(); i++) {

				assertEquals(result.get(i).getId(), y.get(i).getId());
				assertEquals(result.get(i).getName(), y.get(i).getName());
				assertEquals(result.get(i).getAlphaAcid(), y.get(i).getAlphaAcid());
				assertEquals(result.get(i).getCountry(), y.get(i).getCountry());
			}
			
		}
		else
			assertTrue(d == 0);
	}

//	public final void testSave() 
}
