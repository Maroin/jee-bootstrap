package org.isen.draughts.webapp;


import org.isen.draughts.core.enums.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class Puissance4WebIT {

    private WebDriver driver;

    private Puissance4Page page;

    @Before
    public void doBefore() throws Exception {
        driver = new FirefoxDriver();
        // Navigate to the right place
        driver.get("http://localhost:9090/jeedraughtswebapp/index.jsp");
        page = PageFactory.initElements(driver, Puissance4Page.class);
    }

    @After
    public void doAfter() {
        driver.quit();
    }

    @Test
    public void itCanBrowseThePage() throws Exception {
        assertThat(page.hasBoard()).isTrue();
        assertThat(page.getColumnsNumber()).isEqualTo(7);
        assertThat(page.getRowNumber()).isEqualTo(6);
    }

    @Test
    public void aPlayerMayPlayAColumn() throws Exception {
        page.play(3);
        assertThat(page.getCell(3,0)).isEqualTo(Player.BLACK);

        page.play(3);
        assertThat(page.getCell(3,1)).isEqualTo(Player.WHITE);

        assertThat(page.getCell(3,2)).isNull();
        assertThat(page.getCell(4,5)).isNull();
    }

    @Test
    public void aPlayerMayWin() throws Exception {
        assertThat(page.getWinner()).isEqualTo(null);
        page.play(3);
        page.play(2);
        page.play(3);
        page.play(2);
        page.play(3);
        page.play(2);
        page.play(3);

        assertThat(page.getWinner()).isEqualTo(Player.WHITE);
    }

    @Test
    public void aGameMayBeReset() throws Exception {
        page.play(3);
        assertThat(page.getCell(3,0)).isEqualTo(Player.WHITE);
        page.reset();
        assertThat(page.getCell(3,0)).isNull();

    }


}
