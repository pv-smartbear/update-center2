package org.jvnet.hudson.update_center.json;

import com.alibaba.fastjson.annotation.JSONField;
import org.jvnet.hudson.update_center.HPI;
import org.jvnet.hudson.update_center.MavenRepository;

import java.io.IOException;
import java.util.List;

public class PluginVersionsEntry {
    @JSONField
    public final String buildDate;
    @JSONField
    public final String name;
    @JSONField
    public final String requiredCore;
    @JSONField
    public final String sha1;
    @JSONField
    public final String sha256;
    @JSONField
    public final String url;
    @JSONField
    public final String version;
    @JSONField
    public final String compatibleSinceVersion;

    @JSONField
    public final List<HPI.Dependency> dependencies;

    public PluginVersionsEntry(HPI hpi) throws IOException {
        final MavenRepository.Digests digests = hpi.getDigests();
        name = hpi.artifact.artifactId;
        requiredCore = hpi.getRequiredJenkinsVersion();
        sha1 = digests.sha1;
        sha256 = digests.sha256;
        url = hpi.getDownloadUrl().toString();
        version = hpi.version;
        buildDate = hpi.getTimestampAsString();
        dependencies = hpi.getDependencies();
        compatibleSinceVersion = hpi.getCompatibleSinceVersion();
    }
}
