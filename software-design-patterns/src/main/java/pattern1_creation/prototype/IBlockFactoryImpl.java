package pattern1_creation.prototype;

import pattern1_creation.prototype.types.ContentBlock;
import pattern1_creation.prototype.types.DataTimeBlock;
import pattern1_creation.prototype.types.IBlock;
import pattern1_creation.prototype.types.NumberBlock;

import java.time.LocalDateTime;

public class IBlockFactoryImpl implements IBlockFactory {

    @Override
    public IBlock createBlock(String content) {
        if (content.contains("/") || content.contains("-")) {
            // 需要格式化读取的日期字符串
            return new DataTimeBlock(LocalDateTime.parse(content));
        } else if (isNumber(content)) {
            return new NumberBlock(Integer.parseInt(content));
        } else {
            return new ContentBlock(content);
        }
    }

    private boolean isNumber(String content) {
        try {
            Integer.parseInt(content);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
