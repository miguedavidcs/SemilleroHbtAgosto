import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearComponentComponent } from './crear-component.component';

describe('CrearComponentComponent', () => {
  let component: CrearComponentComponent;
  let fixture: ComponentFixture<CrearComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
