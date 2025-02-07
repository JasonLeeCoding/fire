/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zto.fire.flink.sql

import com.zto.fire.common.conf.FireFrameworkConf.buriedPointDatasourceEnable
import com.zto.fire.core.sql.SqlExtensionsParser
import com.zto.fire.flink.util.FlinkUtils
import com.zto.fire.predef.noEmpty

/**
 * flink sql解析器
 *
 * @author ChengLong
 * @date 2022-05-10 10:03:52
 * @since 2.2.2
 */
private[fire] object FlinkSqlExtensionsParser extends SqlExtensionsParser {

  /**
   * 将待解析的SQL添加到buffer中
   */
  def sqlParse(sql: String): Unit = {
    if (buriedPointDatasourceEnable && noEmpty(sql)) {
      FlinkUtils.sqlValidate(sql)
      FlinkSqlParser.sqlParse(sql)
    }
  }
}
