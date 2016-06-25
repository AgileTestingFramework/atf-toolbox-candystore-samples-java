package com.agiletestingframework.candystore.database;

import com.agiletestingframework.toolbox.ATFHandler;
import io.zatarox.squiggle.Order;
import io.zatarox.squiggle.SelectQuery;
import io.zatarox.squiggle.Table;
import io.zatarox.squiggle.criteria.MatchCriteria;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.entry;

public class SchemaValidation {

	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{

	}
    
    @Test(groups = { "database" })
    public void validateCandyTableSchema() {
    	List<String> tables = ATFHandler.getInstance().getDatabaseAutomation().getTables();
		assertThat(tables).hasSize(4)
			.containsOnly("CANDY", "CANDY_ORDER", "CANDY_ORDER_LINE", "CONTACT")
			.doesNotContain("Z_CANDY");
		
		Map<String, Integer> columnAndTypes = ATFHandler.getInstance().getDatabaseAutomation().getColumnsAndTypes("CANDY");
		assertThat(columnAndTypes).hasSize(7)
			.contains(entry("ID", Types.BIGINT));
    }
    
	@Test(groups = { "database" })
	public void SelectDataTest() throws SQLException
	{
		Table tblCandy = new Table("CANDY");
		SelectQuery selectStmnt = new SelectQuery();
		selectStmnt.addToSelection(tblCandy.getWildcard());
		selectStmnt.addCriteria(new MatchCriteria(tblCandy, "CURRENT_QUANTITY", MatchCriteria.GREATER, 700) );
		selectStmnt.addOrder(tblCandy, "CANDY_NAME", Order.ASCENDING);
		
		List<Map<String, Object>> results = ATFHandler.getInstance().getDatabaseAutomation().selectData(selectStmnt);
		
		assertThat(results.size()).isEqualTo(3);
		
		// Assert the first row result is Mars only
		for (Map<String, Object> row : results) {
			assertThat(row).contains(entry("CANDY_NAME", "Mars"));
			
			// Loop on specifc column within the row
		    for (Map.Entry<String, Object> column : row.entrySet()) {
		    	// Assert something here
		    	System.out.println(column.getKey().toString());
		    }
		    
		    // look at a specific column within the row
		    assertThat(Double.parseDouble(row.get("CANDY_PRICE").toString())).isEqualTo(.65);
		    break;
	    }
	}
}
