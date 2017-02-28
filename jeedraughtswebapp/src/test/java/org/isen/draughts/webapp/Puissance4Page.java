package org.isen.draughts.webapp;

import java.util.List;

import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Puissance4Page {

    @FindBy(id = "board")
    WebElement board;

    @FindBy(id = "winner")
    WebElement winner;

    @FindBy(id = "reset")
    WebElement resetButton;

    public Puissance4Page(WebDriver driver) {
        driver.get("http://localhost:9090/jeedraughtswebapp/index.jsp");
    }

    public boolean hasBoard() {
        return board.isDisplayed();
    }

    public void play(int i) {
        List<WebElement> cols = getColumns();
        cols.get(i).click();
    }

    private List<WebElement> getColumns() {
        List<WebElement> cols = board.findElements(By
                .xpath("//a[@class='blue column']"));
        return cols;
    }

    public DraughtCell getCell(int i, int j) {
        String xpath = String
                .format("//a[@class='blue column'][%d]/div", i + 1);
        List<WebElement> cells = Lists.reverse(board.findElements(By
                .xpath(xpath)));

        WebElement cell = cells.get(j);
        String cssClass = cell.getAttribute("class");
        return colourFromClass(cssClass);

    }

    private DraughtCell colourFromClass(String cssClass) {
        DraughtCell cell= new DraughtCell();
        if (cssClass.contains("white")) {
            cell.setPlayer(Player.WHITE);
        } else if (cssClass.contains("black")) {
            cell.setPlayer(Player.BLACK);
        } else {
            cell.setPlayer(null);
        }
        return cell;
    }

    public Integer getColumnsNumber() {
        return getColumns().size();
    }

    public Integer getRowNumber() {
        String xpath = String.format("//a[@class='blue column'][%d]/div", 1);
        List<WebElement> cells = Lists.reverse(board.findElements(By
                .xpath(xpath)));
        return cells.size();
    }

    public void reset() {
        resetButton.click();
    }

    public Player getWinner() {
        try {
            return null;
            //return colourFromClass(winner.getAttribute("class"));
        } catch (NoSuchElementException e) {
            return null;
        }

    }

}
