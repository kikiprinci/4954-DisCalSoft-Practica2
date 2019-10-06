package mastermind.mvc.models;

import java.util.List;
import java.util.ArrayList;

public class Combination {
    private static final int WIDTH = 4;

    protected List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<Color>();
    }

    static int getWidth() {
        return Combination.WIDTH;
    }
}