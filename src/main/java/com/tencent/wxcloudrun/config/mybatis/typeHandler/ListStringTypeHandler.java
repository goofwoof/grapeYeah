package com.tencent.wxcloudrun.config.mybatis.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.tomcat.util.buf.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@MappedJdbcTypes(JdbcType.VARBINARY) // 数据库中该字段存储的类型
@MappedTypes(List.class)
public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {
    private static final Character SPLIT = ',';

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setObject(i, StringUtils.join(parameter, SPLIT));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return formatStringTOListString(rs.getString(columnName));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return formatStringTOListString(rs.getString(columnIndex));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return formatStringTOListString(cs.getString(columnIndex));
    }

    private List<String> formatStringTOListString(String string) {
        return Objects.isNull(string) || string.isEmpty() ? null : Arrays.asList(string.split(String.valueOf(SPLIT)));
    }
}
