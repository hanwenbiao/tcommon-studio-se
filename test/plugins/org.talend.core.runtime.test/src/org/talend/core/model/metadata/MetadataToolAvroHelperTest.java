// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.metadata;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.SchemaBuilder.FieldAssembler;
import org.apache.avro.SchemaBuilder.FieldBuilder;
import org.apache.avro.SchemaBuilder.RecordBuilder;
import org.junit.Test;
import org.talend.core.model.metadata.builder.connection.ConnectionFactory;
import org.talend.core.model.metadata.builder.connection.MetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.daikon.avro.SchemaConstants;
import org.talend.daikon.avro.util.AvroTypes;
import org.talend.daikon.avro.util.AvroUtils;
import org.talend.daikon.talend6.Talend6SchemaConstants;

/**
 * DOC hwang class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 55206 2011-02-15 17:32:14Z mhirt $
 * 
 */
public class MetadataToolAvroHelperTest {

    /**
     * Unit tests for {@link org.talend.core.model.metadata.MetadataToolHelper#convertToAvro(IMetadataTable)}
     * 
     * Test a simple MetadataTable.
     */
    @Test
    public void testConvertToAvro_Basic() {
        // Setup with a test table.
        MetadataTable table = ConnectionFactory.eINSTANCE.createMetadataTable();
        table.setLabel("testTable");
        table.setComment("A comment about this table.");
        ArrayList<org.talend.core.model.metadata.builder.connection.MetadataColumn> columns = new ArrayList<>();
        {
            org.talend.core.model.metadata.builder.connection.MetadataColumn column = ConnectionFactory.eINSTANCE
                    .createMetadataColumn();
            column.setLabel("id");
            column.setTalendType(JavaTypesManager.INTEGER.getId());
            column.setNullable(true);
            columns.add(column);
        }
        {
            org.talend.core.model.metadata.builder.connection.MetadataColumn column = ConnectionFactory.eINSTANCE
                    .createMetadataColumn();
            column.setLabel("name");
            column.setTalendType(JavaTypesManager.STRING.getId());
            column.setNullable(false);
            columns.add(column);
        }
        {
            org.talend.core.model.metadata.builder.connection.MetadataColumn column = ConnectionFactory.eINSTANCE
                    .createMetadataColumn();
            column.setLabel("valid");
            column.setTalendType(JavaTypesManager.BOOLEAN.getId());
            column.setNullable(false);
            columns.add(column);
        }
        {
            org.talend.core.model.metadata.builder.connection.MetadataColumn column = ConnectionFactory.eINSTANCE
                    .createMetadataColumn();
            column.setLabel("dyn");
            column.setTalendType("id_Dynamic");
            column.setNullable(false);
            columns.add(column);
        }
        table.getColumns().addAll(columns);

        Schema s = MetadataToolAvroHelper.convertToAvro(table);

        assertThat(s.getType(), is(Schema.Type.RECORD));
        assertThat(s.getName(), is("testTable"));
        assertThat(s.getFields().size(), is(3));
        // assertThat(s.getObjectProps().keySet(),
        // contains(Talend6SchemaConstants.TALEND6_LABEL, Talend6SchemaConstants.TALEND6_COMMENT));
        assertThat(s.getProp(Talend6SchemaConstants.TALEND6_LABEL), is("testTable"));
        assertThat(s.getProp(Talend6SchemaConstants.TALEND6_COMMENT), is("A comment about this table."));

        Schema.Field f = s.getFields().get(0);
        assertTrue(AvroUtils.isNullable(f.schema()));
        assertThat(AvroUtils.unwrapIfNullable(f.schema()).getType(), is(Schema.Type.INT));
        assertThat(f.name(), is("id"));
        // assertThat(s.getObjectProps().keySet(),
        // contains(Talend6SchemaConstants.TALEND6_LABEL, Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_LABEL), is("id"));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE), is("id_Integer"));

        f = s.getFields().get(1);
        assertThat(f.schema().getType(), is(Schema.Type.STRING));
        assertThat(f.name(), is("name"));
        assertFalse(AvroUtils.isNullable(f.schema()));
        // assertThat(s.getObjectProps().keySet(),
        // contains(Talend6SchemaConstants.TALEND6_LABEL, Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_LABEL), is("name"));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE), is("id_String"));

        f = s.getFields().get(2);
        assertThat(f.schema().getType(), is(Schema.Type.BOOLEAN));
        assertThat(f.name(), is("valid"));
        // assertThat(s.getObjectProps().keySet(),
        // contains(Talend6SchemaConstants.TALEND6_LABEL, Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_LABEL), is("valid"));
        assertThat(f.getProp(Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE), is("id_Boolean"));

        assertThat(s.getProp(SchemaConstants.INCLUDE_ALL_FIELDS), is("true"));
        assertThat(s.getProp(Talend6SchemaConstants.TALEND6_DYNAMIC_COLUMN_NAME), is("dyn"));
        assertThat(s.getProp(Talend6SchemaConstants.TALEND6_DYNAMIC_COLUMN_POSITION), is("3"));
        assertThat(s.getProp(Talend6SchemaConstants.TALEND6_COLUMN_TALEND_TYPE), is("id_Dynamic"));
    }

    @Test
    public void testConvertFromAvro() {
        SortedMap<String, Schema> map = new TreeMap<>();
        map.put(JavaTypesManager.STRING.getId(), AvroTypes._string());
        map.put(JavaTypesManager.LONG.getId(), AvroTypes._long());
        map.put(JavaTypesManager.INTEGER.getId(), AvroTypes._int());
        map.put(JavaTypesManager.SHORT.getId(), AvroTypes._short());
        map.put(JavaTypesManager.BYTE.getId(), AvroTypes._byte());
        map.put(JavaTypesManager.DOUBLE.getId(), AvroTypes._double());
        map.put(JavaTypesManager.FLOAT.getId(), AvroTypes._float());
        map.put(JavaTypesManager.BIGDECIMAL.getId(), AvroTypes._decimal());
        map.put(JavaTypesManager.BOOLEAN.getId(), AvroTypes._boolean());
        map.put(JavaTypesManager.BYTE_ARRAY.getId(), AvroTypes._bytes());
        map.put(JavaTypesManager.DATE.getId(), AvroTypes._date());

        RecordBuilder<Schema> builder = SchemaBuilder.builder().record("MyTable"); //$NON-NLS-1$
        FieldAssembler<Schema> fa = builder.fields();
        for (String talendType : map.keySet()) {
            FieldBuilder<Schema> fb = fa.name(talendType.replace('[', '_').replace(']', '_'));
            fb.prop(Talend6SchemaConstants.TALEND6_LABEL, talendType);
            fa = fb.type(map.get(talendType)).noDefault();
        }
        Schema schema = fa.endRecord();
        MetadataTable table = MetadataToolAvroHelper.convertFromAvro(schema);
        assertEquals(map.size(), table.getColumns().size());
        int i = 0;
        for (String talendType : map.keySet()) {
            assertThat(table.getColumns().get(i).getLabel(), is(talendType));
            assertThat(table.getColumns().get(i).getTalendType(), is(talendType));
            assertThat(table.getColumns().get(i).getPattern(), is("")); //$NON-NLS-1$
            assertThat(table.getColumns().get(i).getLength(), is(-1L));
            assertThat(table.getColumns().get(i).getOriginalLength(), is(-1L));
            assertThat(table.getColumns().get(i).getPrecision(), is(-1L));
            assertThat(table.getColumns().get(i).getScale(), is(-1L));
            i++;
        }
    }
}
