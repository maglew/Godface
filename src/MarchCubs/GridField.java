package MarchCubs;

import org.lwjgl.util.vector.Vector3f;

public class GridField
{
    Vector3f begin;
    Vector3f end;
    Gridcell grids[];

    public GridField(Vector3f begin, Vector3f end) {
        this.begin = begin;
        this.end = end;

    }
}
