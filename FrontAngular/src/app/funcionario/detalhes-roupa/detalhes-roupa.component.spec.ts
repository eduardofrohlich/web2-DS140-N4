import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesRoupaComponent } from './detalhes-roupa.component';

describe('DetalhesRoupaComponent', () => {
  let component: DetalhesRoupaComponent;
  let fixture: ComponentFixture<DetalhesRoupaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalhesRoupaComponent]
    });
    fixture = TestBed.createComponent(DetalhesRoupaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
