import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class EraserTest {
    private Eraser eraser;

    @Before
    public void setup(){
        eraser =  new Eraser();
    }

    @Test
    public void EraseReplacesGivenTextWithSpaces(){
        Paper paperWithText = new Paper("Apple Banana Onion");

        eraser.erase(paperWithText, "Banana");

        assertEquals("Apple        Onion", paperWithText.getText());
    }

    @Test
    public void EraseReplacesLastOccurrenceOfAWordWithSPaces(){
        Paper paperWithText = new Paper("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase(paperWithText, "chuck");

        assertEquals("How much wood would a woodchuck chuck if a woodchuck could       wood?", paperWithText.getText());
    }

    @Test
    public void ErasingAWordASecondTimeWillReplaceTheNextLastOccurrenceOfTheWord(){
        Paper paperWithText = new Paper("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase(paperWithText, "chuck");
        eraser.erase(paperWithText, "chuck");

        assertEquals("How much wood would a woodchuck chuck if a wood      could       wood?", paperWithText.getText());
    }
}
