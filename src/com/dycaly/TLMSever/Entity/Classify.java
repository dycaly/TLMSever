package com.dycaly.TLMSever.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classify entity. @author MyEclipse Persistence Tools
 */

public class Classify implements java.io.Serializable {

	// Fields

	private Integer classifyId;
	private Classify classify;
	private String name;
	private Integer layer;
	private Set products = new HashSet(0);
	private Set classifies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classify() {
	}

	/** minimal constructor */
	public Classify(Integer classifyId, Classify classify, String name,
			Integer layer) {
		this.classifyId = classifyId;
		this.classify = classify;
		this.name = name;
		this.layer = layer;
	}

	/** full constructor */
	public Classify(Integer classifyId, Classify classify, String name,
			Integer layer, Set products, Set classifies) {
		this.classifyId = classifyId;
		this.classify = classify;
		this.name = name;
		this.layer = layer;
		this.products = products;
		this.classifies = classifies;
	}

	// Property accessors

	public Integer getClassifyId() {
		return this.classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Classify getClassify() {
		return this.classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLayer() {
		return this.layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	public Set getClassifies() {
		return this.classifies;
	}

	public void setClassifies(Set classifies) {
		this.classifies = classifies;
	}

}