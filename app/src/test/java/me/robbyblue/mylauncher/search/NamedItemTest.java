package me.robbyblue.mylauncher.search;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import me.robbyblue.mylauncher.files.FileNode;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NamedItemTest {

    @Parameterized.Parameter(0)
    public String input;

    @Parameterized.Parameter(1)
    public String expected;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "Paramètres", "parametres" },
            { "Über", "uber" },
            { "Español", "espanol" },
            { "niño", "nino" },
            { "Ça fait très beau", "ca fait tres beau" },
            { "Settings", "settings" },
            { "PARAMETRES", "parametres" },
            { "RÉsumÉ", "resume" },
            { "Crème brulée", "creme brulee" },
            { "naïve", "naive" },
            { "façade", "facade" },
            { "Jörg", "jorg" },
        });
    }

    @Test
    public void normalizeAccents() {
        FileNode mockFileNode = null;
        NamedItem item = new NamedItem(input, mockFileNode);
        item.normalizeAccents();
        assertEquals(expected, item.getName());
    }
}
