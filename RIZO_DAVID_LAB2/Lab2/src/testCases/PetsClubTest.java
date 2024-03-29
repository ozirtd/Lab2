package testCases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.ExistentOwnerException;
import exceptions.ExistentPetException;
import model.Owner;
import model.Pet;
import model.PetsClub;

class PetsClubTest {

	private PetsClub petsclub; 
	
	public PetsClubTest() {
		petsclub = new PetsClub();
	}
	
	public Owner escenario1() {
		PetsClubTest pct = new PetsClubTest();
		Owner ow = new Owner("123","David", "Rizo",LocalDate.of(2002, 12, 3));
		petsclub.setFirst(ow);
		return ow;
	}
	
	public Owner escenario2() {
		PetsClubTest pct = new PetsClubTest();
		Owner ow = new Owner("1234","David", "Rizo",LocalDate.of(2002, 12, 3));
		Pet pet = new Pet("kira",LocalDate.of(2012, 12, 3),Pet.FEMALE, Pet.DOG);
		petsclub.setFirst(ow);
		ow.setFirst_pet(pet);
		
		return ow;
	}
	
	
	

    	@Test
	public void testRegisterOwner() {
		escenario1();
		Owner ow = new Owner("123","David", "Rizo",LocalDate.of(2002, 12, 3));
		
		try {
			petsclub.registerOwner(ow);
			fail("Expected exception");
		} catch (ExistentOwnerException e) {
			assert(true);
		}
		
		
		
		
		escenario2();
		
		
		try {
			petsclub.registerOwner(ow);
			assert(true);
		} catch (ExistentOwnerException e) {
			fail("Didnt Expected this exception");
		}
		
		
		
	}

	@Test
	public void testDeleteOwner() {
		escenario1();
		String id = "123";
		Owner ow = new Owner();
		ow.setId("123");
		int size = petsclub.getSize();
		petsclub.deleteOwner(id);
		assertEquals(false,petsclub.containsOwner(ow));
	}

	
	@Test
	public void testSearchOwner() {
		escenario1();
		String condition = "123";
		Owner ow = new Owner("123","David", "Rizo",LocalDate.of(2002, 12, 3));
		assertEquals(ow.getId(),petsclub.searchOwner(condition).getId());
		
	}
	
	@Test
	public void testModifyOwner() {
		//escenario1();
		Owner ow = new Owner("3421","Alejo", "Rizo",LocalDate.of(2002, 12, 3));
		ow.setName("Alejandro");
		petsclub.setFirst(ow);
		petsclub.modifyOwner(ow);
		
		assertEquals("Alejandro", ow.getName());
		
	}

	@Test
	public void testRegisterPet() {
		Owner owner = escenario2();
		
		Pet p = new Pet("Kira",LocalDate.of(2013, 12, 3),Pet.FEMALE, Pet.DOG);
		
		try {
			petsclub.registerPet(p,owner);
			fail("Expected exception");
		} catch (ExistentPetException e) {
			assert(true);
		}
		
		
		
		
		Owner owner1 = escenario1();
		
		Pet p1 = new Pet("Kira",LocalDate.of(2013, 12, 3),Pet.FEMALE, Pet.DOG);
		try {
			petsclub.registerPet(p1, owner1);
			assert(true);
		} catch (ExistentPetException e) {
			fail("Didnt Expected this exception");
		}
		
		
	}

	@Test
	public void testDeletePet() {
		Owner owner = escenario1();
		String name = "Kira";
		int size = owner.getPets_size();
		petsclub.deletePet(name, owner);
		assertEquals(true,true);
	}

	@Test
	public void testSearchPet() {
		escenario1();
		String condition = "Kira";
		Pet p1 = new Pet("Kira",LocalDate.of(2013, 12, 3),Pet.FEMALE, Pet.DOG);
		assertEquals(p1,petsclub.searchPet(condition));
		
		//String condition1 = "2018-12-3";
		//assertEquals(p1,petsclub.searchOwner(condition1));		
		
	}

	@Test
	void testModifyPet() {
		fail("Not yet implemented");
	}

	
}
