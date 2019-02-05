package main;

import view.ViewPrincipal;

public class Principal {

	public static void main(String[] args) {
		ViewPrincipal view = new ViewPrincipal();
		view.setTitle("Conciliação");
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		
//		Pessoa p = new Pessoa(null,"davan", "dalvan.schmitz@gmail.com");
//		Pessoa p1 = new Pessoa(null,"davan2", "dalvan.schmitz@gmail.com");
//		Pessoa p2 = new Pessoa(null,"davan3", "dalvan.schmitz@gmail.com");
		
//		Cartao c = new Cartao();
//		c.setBandeiraId(2);
//		c.setDtTransacao(new Date());
//		c.setDtUltStatus(new Date());
//		c.setMeioCaptura("pos");
//		c.setNrCartao("546452******8663");
//		c.setSerialNember(51539036);
//		c.setStoneId("37470653800222");
//		c.setTipoTransacaoId(1);
//		c.setUltStatus("Capturada");
//		c.setVlrBruto(new BigDecimal(30.25));
//		c.setVlrLiquido(new BigDecimal(32.25));
		

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conciliacao");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(c);
//		em.persist(p2);
//		em.persist(p1);
		
//		Cartao p = em.find(Cartao.class, 1);
//		Query select = em.createQuery("FROM Cartao ");
//		List<Cartao> list = select.getResultList();
//		System.out.println(list.get(0).getBandeira());

		// em.remove(p);

//		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}

}
