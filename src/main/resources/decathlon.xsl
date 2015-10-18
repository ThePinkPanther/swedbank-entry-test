<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/decathlonResults">
        <html>
            <head>
                <style>
                    th {
                        height: 60px;
                        width: 80px;
                    }
                    td,th {
                        padding: 4px;
                        min-width: 50px;
                    }
                    tr:first-child {
                        background-color: #222;
                        color: #eee;
                    }
                    tr:nth-child(even) {
                        background-color: #eee;
                    }
                </style>
            </head>
            <body>
                <table>
                    <tr>
                        <th>name</th>
                        <th>100 metres sprint</th>
                        <th>long jump</th>
                        <th>shot put</th>
                        <th>high jump</th>
                        <th>400 metres sprint</th>
                        <th>110 metres hurdle</th>
                        <th>discus throw</th>
                        <th>pole vault</th>
                        <th>javelin throw</th>
                        <th>1500 metres run</th>
                        <th>points</th>
                        <th>position</th>
                    </tr>
                    <xsl:for-each select="decathlonResult">
                        <tr>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="oneHundredMetresSprintTime"/> s
                            </td>
                            <td>
                                <xsl:value-of select="longJumpDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="shotPutDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="highJumpDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="fourHundredMetresSprintTime"/> s
                            </td>
                            <td>
                                <xsl:value-of select="oneHundredTenMetresHurdleTime"/> s
                            </td>
                            <td>
                                <xsl:value-of select="discusThrowDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="poleVaultDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="javelinThrowDistance"/> m
                            </td>
                            <td>
                                <xsl:value-of select="oneThousandFiveHoundedMetresRunTime"/> m
                            </td>
                            <td>
                                <xsl:value-of select="points"/>
                            </td>
                            <td>
                                <xsl:if test="position/from = position/to">
                                    <xsl:value-of select="position/from"/>
                                </xsl:if>
                                <xsl:if test="position/from != position/to">
                                    <xsl:value-of select="position/from"/>-<xsl:value-of
                                        select="position/to"/>
                                </xsl:if>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>