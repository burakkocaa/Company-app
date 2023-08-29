package com.example.demo.entities.concretes;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    	
		@Column( updatable = false, nullable = false)
    	private UUID id;

	    @Column(nullable = true, name = "created_at")
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = true, name = "updated_at")
	    @LastModifiedDate
	    private Date updatedAt;
	    
	    @Column(name = "created_by")
	    private UUID createdBy;
	    
	    
	    @Column(name = "updated_by")
	    private UUID updatedBy;
	   
	    @Column(nullable = false, name="full_name")
		private String name;
		
	    @OneToMany(mappedBy = "company")
	    private List<User> users;

	    
}
	    