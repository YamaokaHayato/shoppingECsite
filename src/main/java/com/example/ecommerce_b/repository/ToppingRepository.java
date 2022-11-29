package com.example.ecommerce_b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_b.domain.Topping;

/**
 * toppingsテーブルを操作するリポジトリ.
 * 
 * @author yamaokahayato
 *
 */
@Repository
public class ToppingRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Toppingオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Topping> TOPPING_ROWMAPPER = (rs, i) -> {	
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};
	
	/**
	 * トッピング情報を全件検索する.
	 * 
	 * @return トッピング一覧
	 */
	public List<Topping> findAll() {
		String sql = "SELECT id, name, price_m, price_l FROM toppings";
		List<Topping> toppingList = template.query(sql, TOPPING_ROWMAPPER);
		return toppingList;
	}
	

}
