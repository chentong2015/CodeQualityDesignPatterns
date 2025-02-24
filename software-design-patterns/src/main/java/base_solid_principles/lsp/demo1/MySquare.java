package base_solid_principles.lsp.demo1;

public class MySquare extends MyRectangle {

    @Override
    public void setWidth(int width) {
        m_width = width;
        m_height = width;
    }

    public void setHeight(int height) {
        m_width = height;
        m_height = height;
    }
}
