package io.github.noorulhaq.metrics.hystrix;

/**
 * Created by husainbasrawala on 1/2/17.
 */

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.netflix.hystrix.*;
import com.netflix.hystrix.contrib.codahalemetricspublisher.HystrixCodaHaleMetricsPublisherCommand;

public class DropWizardPublisherCommand extends HystrixCodaHaleMetricsPublisherCommand {
    protected final HystrixCommandMetrics metrics;
    protected final MetricRegistry metricRegistry;

    public DropWizardPublisherCommand(HystrixCommandKey commandKey,
                                      HystrixCommandGroupKey commandGroupKey,
                                      HystrixCommandMetrics metrics,
                                      HystrixCircuitBreaker circuitBreaker,
                                      HystrixCommandProperties properties,
                                      MetricRegistry metricRegistry) {
        super(commandKey, commandGroupKey, metrics, circuitBreaker, properties, metricRegistry);
        this.metrics = metrics;
        this.metricRegistry = metricRegistry;
    }

    @Override
    public void initialize() {
        super.initialize();
        metricRegistry.register(createMetricName("latencyExecute_percentile_95"), new Gauge<Integer>() {
            public Integer getValue() {
                return metrics.getExecutionTimePercentile(95);
            }
        });
        metricRegistry.register(createMetricName("latencyExecute_percentile_999"), new Gauge<Integer>() {
            public Integer getValue() {
                return metrics.getExecutionTimePercentile(99.9);
            }
        });
        metricRegistry.register(createMetricName("latencyTotal_percentile_95"), new Gauge<Integer>() {
            public Integer getValue() {
                return metrics.getTotalTimePercentile(95);
            }
        });
        metricRegistry.register(createMetricName("latencyTotal_percentile_999"), new Gauge<Integer>() {
            public Integer getValue() {
                return metrics.getTotalTimePercentile(99.9);
            }
        });
    }
}
